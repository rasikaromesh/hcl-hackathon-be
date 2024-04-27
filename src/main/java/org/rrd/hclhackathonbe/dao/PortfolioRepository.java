package org.rrd.hclhackathonbe.dao;

import org.rrd.hclhackathonbe.domain.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

}
