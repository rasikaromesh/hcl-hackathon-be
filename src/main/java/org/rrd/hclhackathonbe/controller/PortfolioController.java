package org.rrd.hclhackathonbe.controller;

import org.rrd.hclhackathonbe.domain.Customer;
import org.rrd.hclhackathonbe.domain.Portfolio;
import org.rrd.hclhackathonbe.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/portfolios")
public class PortfolioController {

    @Autowired
    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping("/{portfolioId}")
    public ResponseEntity<?> getPortfolioById(@PathVariable String portfolioId) {
        Portfolio portfolio = portfolioService.getPortfolioById(portfolioId);
        return ResponseEntity.ok(portfolio);
    }

    @PostMapping
    public ResponseEntity<?> createPortfolio(@RequestBody Portfolio portfolio) {
        Portfolio createdPortfolio = portfolioService.createPortfolio(portfolio);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPortfolio);
    }

    @GetMapping
    public ResponseEntity<List<Portfolio>> getAllPortfolios(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int size){
        Page<Portfolio> portfolio = portfolioService.getAllPortfolio(PageRequest.of(page, size));
        return ResponseEntity.ok(portfolio.toList());

    }

}
