package com.scg.employee.fiegn.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "attendanceservice", url = "http://localhost:8081/attendance")

public interface AttendanceServiceProxy {

	@GetMapping("/id/{id}")
	String getEmployeeAttendanceById(@RequestParam("id") final int id);

}
