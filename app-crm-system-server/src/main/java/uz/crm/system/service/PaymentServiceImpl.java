package uz.crm.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.crm.system.entity.catalogs.Payment;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.exception.BadRequestException;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqPayment;
import uz.crm.system.payload.ResPageable;
import uz.crm.system.payload.ResPayment;
import uz.crm.system.repository.PaymentRepository;
import uz.crm.system.repository.rest.RestaurantRepository;
import uz.crm.system.utils.CommonUtils;

import java.util.UUID;
import java.util.stream.Collectors;

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
            payment.setCustomerCard(request.getCustomerCard());
            payment.setOrder(null); //Fill content after CRUD Order Entity
            payment.setExtraInfo(request.getExtraInfo());
            paymentRepository.save(payment);
            return new ApiResponse(request.getId() == null ? "Оплата сохранен!" : "Оплата изменен!", true);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), false);
        }
    }

    @Override
    public ResPayment getPayment(Payment payment) {

        return new ResPayment(
                payment.getId(),
                payment.getCode(),
                payment.getSum(),
                payment.getRestaurant().getId(),
                payment.getRestaurant().getCode(),
                payment.getPayTypeEnum(),
                payment.getUser().getId(),
                payment.getTerminalNumber(),
                payment.getCustomerCard(),
                payment.getOrder().getId(),
                payment.getOrder().getCode(),
                payment.getExtraInfo()
        );
    }

    @Override
    public ResPageable getPayments(int page, int size, boolean sort) throws BadRequestException {

        CommonUtils.getPageable(page, size);
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        Page<Payment> paymentPage = paymentRepository.findAll(pageable);
        return new ResPageable(
                paymentPage.getTotalPages(),
                paymentPage.getTotalElements(),
                page,
                paymentPage.getContent().stream().map(this::getPayment).collect(Collectors.toList()));
    }

    @Override
    public ApiResponse deletePayment(UUID id) {

        try {
            paymentRepository.deleteById(id);
            return new ApiResponse("Объект удален!", true);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), false);
        }
    }
}
