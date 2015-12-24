package com.daocheng;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.apache.thrift.TException;

import com.daocheng.idl.gen.NormalDate;

public class WeekendCheckerHandler implements com.daocheng.idl.gen.WeekendChecker.Iface{

	@Override
	public boolean isWeekend(NormalDate inDate) throws TException {
		
		LocalDate dateIn = LocalDate.of(inDate.year, inDate.month, inDate.day);
		
		DayOfWeek dayofWeek  = dateIn.getDayOfWeek();
		
		return ((dayofWeek.compareTo(DayOfWeek.SATURDAY) == 0) | (dayofWeek.compareTo(DayOfWeek.SUNDAY) == 0));

	}

}
