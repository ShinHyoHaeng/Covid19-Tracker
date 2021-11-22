package io.haeng.covid19tracker.controllers;

import io.haeng.covid19tracker.models.LocationStats;
import io.haeng.covid19tracker.services.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DecimalFormat;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CovidDataService covidDataService;

    @GetMapping("/")
    public String home(Model model) {
        List<LocationStats> allStats = covidDataService.getAllStats();
        DecimalFormat formatter = new DecimalFormat("###,###");

        int totalReportedCasesInt = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        String totalReportedCases = formatter.format(totalReportedCasesInt);

        int totalNewCasesInt = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()) .sum();
        String totalNewCases = formatter.format(totalNewCasesInt);

        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);
        return "home";
    }
}
