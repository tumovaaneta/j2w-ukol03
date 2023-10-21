package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entita.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {
    private final List<Vizitka> seznamVizitek = List.of(
            new Vizitka("Dita (Přikrylová) Formánková", "Czechita z.s.", "Václavské náměstí 837/11",
                    "11000", "dita@zcechitas.cz", "+420 800123456", "www.czechitas.cz"),
            new Vizitka("Barbora Bühnová", "Czechita z.s.", "Václavské náměstí 837/11", "" +
                    "11000", null, "+420 800123456", "www.czechitas.cz"),
            new Vizitka("Monika Ptáčníková", "Czechitas z. s.", "Václavské náměstí 837/11",
                    "11000", "monika@czechitas.cs", "+420 800123456", "www.czechitas.cz"),
            new Vizitka("Mirka Zatloukalová", "Czechitas z. s.", "Václavské námestí 837/11",
                    "14000", "mirka@czechitas.cs", "+420 800123456", "www.czechitas.cz"),
            new Vizitka("Jan Novák", "Nová firma a.s.", "Na hřebenech II 1718",
                    "14000", null, "+420 777777777", "www.novafirma.cz"),
            new Vizitka("Jana Černá", "Nová firma a.s.", "Na hřebenech II 1718",
                    "14000", "cerna@novafirma.cz", "+420 725777777", "www.novafirma.cz"),
            new Vizitka("Karel Žlutý", "Nová firma a.s.", "Na hřebenech II 1718",
                    "14000", null, null, null)
            );

    @GetMapping("/")
    public ModelAndView seznam() {
        ModelAndView modelAndView = new ModelAndView("/seznam");
        modelAndView.addObject("vizitky", seznamVizitek);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("vizitka", seznamVizitek.get(id));
        return modelAndView;
    }

}
