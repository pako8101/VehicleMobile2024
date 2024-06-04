package Vehiclemobile2024.web;

import Vehiclemobile2024.model.AddOfferDto;
import Vehiclemobile2024.model.enums.EngineTypeEnum;
import Vehiclemobile2024.service.OfferService;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }
@ModelAttribute("allEngineTypes")
public EngineTypeEnum[] allEngineTypes(){
        return EngineTypeEnum.values();
}
    @GetMapping("/add")
    public String addOffer(Model model){
        if (!model.containsAttribute("addOfferDto")) {
            model.addAttribute("addOfferDto",AddOfferDto.empty());
        }
       // model.addAttribute("allEngineTypes", EngineTypeEnum.values());
        return "offer-add";
    }

    @PostMapping("/add")
    public String createOffer(@ModelAttribute("addOfferDto") @Valid AddOfferDto addOfferDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addOfferDto", addOfferDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework" +
                            ".validation.BindingResult.addOfferDto",
                    bindingResult);
return "redirect:/offers/add";
        }

     long newOfferID =    offerService.createOrder(addOfferDto);


        return "redirect:/offers/" + newOfferID;

    }

}
