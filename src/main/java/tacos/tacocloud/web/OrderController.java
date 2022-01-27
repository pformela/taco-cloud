package tacos.tacocloud.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import tacos.tacocloud.Order;
import tacos.tacocloud.Taco;
import tacos.tacocloud.TacoOrderTacos;
import tacos.tacocloud.data.OrderRepository;
import tacos.tacocloud.data.TacoOrderTacosRepository;

import javax.validation.Valid;


@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    private OrderRepository orderRepo;
    private TacoOrderTacosRepository tacoOrderTacosRepo;

    @Autowired
    public OrderController(OrderRepository orderRepo, TacoOrderTacosRepository tacoOrderTacosRepo) {
        this.orderRepo = orderRepo;
        this.tacoOrderTacosRepo = tacoOrderTacosRepo;
    }

    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@ModelAttribute("order") @Valid Order order, Errors result,
                               SessionStatus sessionStatus) {

        if(result.hasErrors()) {
            return "orderForm";
        }
        orderRepo.save(order);
        for (Taco taco : order.getTacos()) {
            tacoOrderTacosRepo.save(new TacoOrderTacos(order, taco));
        }
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
