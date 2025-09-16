package Avaliativos.Lista07.Jogador

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time")
public class TimeController {

    private final TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("/principal")
    public List<Jogador> getTitulares() {
        return timeService.getTitulares();
    }

    @GetMapping("/reservas")
    public List<Jogador> getReservas() {
        return timeService.getReservas();
    }

    // PUT /time/jogador/{posicao}?reserva=1
    @PutMapping("/jogador/{posicao}")
    public String substituirJogador(@PathVariable int posicao,
                                    @RequestParam int reserva) {
        return timeService.substituirJogador(posicao, reserva);
    }
}
