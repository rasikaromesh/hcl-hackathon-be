package org.rrd.hclhackathonbe.service;

import org.rrd.hclhackathonbe.domain.Customer;
import org.rrd.hclhackathonbe.domain.Portfolio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PortfolioService {

    Portfolio getPortfolioById(String portfolioId);
    Portfolio createPortfolio(Portfolio Portfolio);

    Page<Portfolio> getAllPortfolio(PageRequest pageRequest);
}
