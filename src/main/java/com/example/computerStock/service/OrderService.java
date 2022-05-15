package com.example.computerStock.service;

import com.example.computerStock.domain.Order;
import com.example.computerStock.domain.Position;
import com.example.computerStock.domain.Role;
import com.example.computerStock.domain.pcComponents.Product;
import com.example.computerStock.repos.OrderRepo;
import com.example.computerStock.repos.PositionRepo;
import com.example.computerStock.repos.pcComponents.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private PositionRepo positionRepo;
    @Autowired
    private OrderRepo orderRepo;

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

    public void addPosition(Integer num, Order order, Long id) {
        Product product = productRepo.findProductById(id);
        for(int i=0; i<num;i++){
            Position pos = new Position(order, product);
            positionRepo.save(pos);
        }
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
}
