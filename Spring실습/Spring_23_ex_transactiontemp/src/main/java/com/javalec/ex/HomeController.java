package com.javalec.ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalec.tcommand.TCommand;
import com.javalec.tcommand.TicketCommand;
import com.javalec.tdto.TicketDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private TCommand ticketCommand;
	
	@Autowired
	public void setTicketCommand(TCommand ticketCommand) {
		this.ticketCommand = ticketCommand;
	}
	
	@RequestMapping("/buy_ticket")
	public String buy_ticket() {
		return "buy_ticket";
	}
	@RequestMapping("/buy_ticket_card")
	public String buy_ticket_card(TicketDto ticketDto,Model model) {
		System.out.println("buy_ticket_card");
		System.out.println("ticketDto : " +ticketDto.getConsumerId());
		System.out.println("ticketDto : " +ticketDto.getAmount());
		
		ticketCommand.execute(ticketDto);
		model.addAttribute("ticketInfo",ticketDto);
		
		return "buy_ticket_end";
	}
	
	
}
