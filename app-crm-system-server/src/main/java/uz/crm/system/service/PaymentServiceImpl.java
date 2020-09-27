package uz.crm.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.crm.system.entity.catalogs.Payment;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqPayment;
import uz.crm.system.repository.PaymentRepository;
import uz.crm.system.repository.rest.RestaurantRepository;
import uz.crm.system.utils.CommonUtils;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public ApiResponse addPayment(ReqPayment request, User user) {

        try {
            Payment payment = new Payment();
            if (request.getId() != null)
                payment = paymentRepository.findById(request.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("getPayment"));
            payment.setCode(CommonUtils.GenerateNewCode(paymentRepository.getMaxCode()));
            payment.setSum(request.getSum());
            payment.setRestaurant(restaurantRepository.findById(request.getRestaurantId())
                    .orElseThrow(() -> new ResourceNotFoundException("getRestaurant")));
            payment.setPayTypeEnum(request.getPayTypeEnum());
            payment.setUser(user);
            payment.setTerminalNumber(request.getTerminalNumber());
            payment.setClientCard(request.getClientCard());
            payment.setOrderDoc(null); //Fill content after CRUD OrderDoc Entity
            payment.setExtraInfo(request.getExtraInfo());
            paymentRepository.save(payment);
            return new ApiResponse(request.getId() == null ? "Оплата сохранен!" : "Оплата изменен!", true);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), false);
        }
    }
}
