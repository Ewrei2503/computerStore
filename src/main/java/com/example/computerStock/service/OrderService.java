package com.example.computerStock.service;

import com.example.computerStock.domain.Order;
import com.example.computerStock.domain.Position;
import com.example.computerStock.domain.Sold;
import com.example.computerStock.domain.pcComponents.Product;
import com.example.computerStock.repos.MessageRepo;
import com.example.computerStock.repos.OrderRepo;
import com.example.computerStock.repos.PositionRepo;
import com.example.computerStock.repos.SoldRepo;
import com.example.computerStock.repos.pcComponents.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private PositionRepo positionRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private SoldRepo soldRepo;

    @Autowired
    private ProductService productService;

    public boolean checkProduct(Long id){
        Product productFromDb = productRepo.findProductById(id);

        if(productFromDb != null) return false;
        return true;
    }

    public List<Order> findAll(){
        return orderRepo.findAll();
    }

    public boolean addOrder(Boolean type){
        Order order = new Order(type);
        orderRepo.save(order);
        return true;
    }

    public void addPosition(Integer num, Order order, Long id, Boolean in) {
        Product product = productRepo.findProductById(id);
        if(!in) {
            product.setNum(product.getNum() - num);
        }
        for(int i=0; i<num;i++){
            Position pos = new Position(order, product);
            positionRepo.save(pos);
        }
        productRepo.save(product);
    }

    public List<Position> findOrderData(Order order) {
        return positionRepo.findByOrderId(order.getId());
    }

    public void deletePosition(Position pos){
        Product prod = productRepo.findProductById(pos.getProduct().getId());
        prod.setNum(prod.getNum()+1);
        positionRepo.removeById(pos.getId());
    }

    public void deleteOrder(Order order) {
        List<Position> pos = positionRepo.findByOrderId(order.getId());
        for(Position pos1 : pos){
            positionRepo.removeById(pos1.getId());
        }
        orderRepo.removeById(order.getId());
    }

    public void resolveNumbers(Order order) {
        List<Position> pos = positionRepo.findByOrderId(order.getId());
        Product prod;
        for(Position pos1 : pos){
            prod = productRepo.findProductById(pos1.getProduct().getId());
            prod.setNum(prod.getNum()+1);
            productService.addProduct(prod);
        }
        deleteOrder(order);
    }

    public void acceptOrder(Long id) {
        Order order = orderRepo.findOrderById(id);
        List<Position> pos = positionRepo.findByOrderId(order.getId());
        Sold sold;
        Product prod;
        messageRepo.removeMessageById(id);
        for(Position pos1 :pos){
            prod = new Product(productRepo.findProductById(pos1.getProduct().getId()));
            sold = new Sold(pos1, prod);
            soldRepo.save(sold);
        }
        deleteOrder(order);
    }

    public void deletePositions(Long id) {
        List<Position> pos = positionRepo.findByProductId(id);
        for(Position pos1 : pos){
            positionRepo.removeById(pos1.getId());
        }
        List<Sold> sold1 = soldRepo.findSoldByProductId(id);
        for(Sold sold: sold1){
            positionRepo.removeById(sold.getId());
        }
    }
}
