package org.rrd.hclhackathonbe.service.impl;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.rrd.hclhackathonbe.dao.PortfolioRepository;
import org.rrd.hclhackathonbe.domain.Portfolio;
import org.rrd.hclhackathonbe.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private final PortfolioRepository portfolioRepository;

    public PortfolioServiceImpl(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    public Portfolio getPortfolioById(String portfolioId) {
        return portfolioRepository.findById(Long.valueOf(portfolioId))
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found with id: " + portfolioId));
    }

    @Override
    public Portfolio createPortfolio(Portfolio Portfolio) {
        return portfolioRepository.save(Portfolio);
    }

    @Override
    public Page<Portfolio> getAllPortfolio(PageRequest pageRequest) {
        return portfolioRepository.findAll(pageRequest);
    }
}
