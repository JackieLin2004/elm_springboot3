package ynu.jackielin.elm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import ynu.jackielin.elm.entity.po.DeliveryAddress;
import ynu.jackielin.elm.mapper.DeliveryAddressMapper;
import ynu.jackielin.elm.service.DeliveryAddressService;

@Service
public class DeliveryAddressServiceImpl extends ServiceImpl<DeliveryAddressMapper, DeliveryAddress>
        implements DeliveryAddressService {
}
