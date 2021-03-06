package tmall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tmall.mapper.CommentMapper;
import tmall.pojo.Comment;
import tmall.pojo.CommentExample;
import tmall.pojo.Order;
import tmall.pojo.OrderItem;
import tmall.pojo.base.BasePOJO;
import tmall.service.CommentService;
import tmall.service.OrderItemService;
import tmall.service.OrderService;

import java.util.Date;
import java.util.List;

/**
 * @author littlestar
 */
@Service
public class CommentServiceImpl extends BaseServiceImpl<CommentMapper,CommentExample>
        implements CommentService {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Override
    public boolean checkFinishComment(Order order) {
        List<OrderItem> orderItems = order.getOrderItems();
        for(OrderItem orderItem:orderItems){
            if(orderItem.getComment()==null){
                return false;
            }
        }
        return true;
    }

    @Override
    public void delete(BasePOJO object) throws Exception {
        object.setDeleteAt(new Date());
        System.out.println("重写");
        mapper.updateByPrimaryKey(object);
    }
}