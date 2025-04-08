package com.dineq.dineqbe.controller;

import com.dineq.dineqbe.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/store/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    /**
     * 기간 별 총 매출 조회
     * [GET] /api/v1/store/reports/sales?startDate={yyyy-mm-dd}&endDate={yyyy-mm-dd}
     * @param startDate
     * @param endDate
     * @return
     */
    @GetMapping("/sales")
    public ResponseEntity<Map<String, Integer>> getTotalSales(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        int totalSales = reportService.getTotalSales(startDate, endDate);
        return ResponseEntity.ok(Map.of("totalSales", totalSales));
    }
}
