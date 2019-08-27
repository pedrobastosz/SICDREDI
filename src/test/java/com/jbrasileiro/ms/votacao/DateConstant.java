package com.jbrasileiro.ms.votacao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public final class DateConstant {

	public static final LocalDate NOW_LOCALDATE = LocalDate.parse("2000-12-01");
	public static final Date NOW_DATE = Date.from(NOW_LOCALDATE.atStartOfDay(ZoneId.systemDefault()).toInstant());
}
