package com.javalec.tcommand;

import com.javalec.tdto.TicketDto;

public interface TCommand {
	
	public void execute(TicketDto ticketDto);
}
