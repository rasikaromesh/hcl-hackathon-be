package org.rrd.hclhackathonbe.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.rrd.hclhackathonbe.constant.InvestmentStrategy;

import java.math.BigDecimal;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String portfolioNumber;
    private BigDecimal portfolioValue;
    private Double currentPerformance;
    private InvestmentStrategy investmentStrategy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPortfolioNumber() {
        return portfolioNumber;
    }

    public void setPortfolioNumber(String portfolioNumber) {
        this.portfolioNumber = portfolioNumber;
    }

    public BigDecimal getPortfolioValue() {
        return portfolioValue;
    }

    public void setPortfolioValue(BigDecimal portfolioValue) {
        this.portfolioValue = portfolioValue;
    }

    public Double getCurrentPerformance() {
        return currentPerformance;
    }

    public void setCurrentPerformance(Double currentPerformance) {
        this.currentPerformance = currentPerformance;
    }

    public InvestmentStrategy getInvestmentStrategy() {
        return investmentStrategy;
    }

    public void setInvestmentStrategy(InvestmentStrategy investmentStrategy) {
        this.investmentStrategy = investmentStrategy;
    }
}
