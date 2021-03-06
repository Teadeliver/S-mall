package tmall.service;

import tmall.pojo.Order;
import tmall.pojo.User;
import tmall.pojo.base.BasePOJO;

import java.util.Date;

public interface CommentService extends BaseService{
    /**
     *
     * @param order 待检测的 order
     * @return 如果已评论完该订单下的所有商品，则返回true，否则返回false
     */
    public boolean checkFinishComment(Order order);

    @Override
    public void delete(BasePOJO object) throws Exception;

}