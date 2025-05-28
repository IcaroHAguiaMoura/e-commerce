package com.curso.resources;

import com.curso.domains.Pedido;
import com.curso.domains.dtos.PedidoDTO;
import com.curso.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<PedidoDTO> listar() {
        return pedidoService.ListarPedidos()
                .stream()
                .map(PedidoDTO::new)
                .toList();
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> criar(@RequestBody PedidoDTO dto) {
        Pedido pedido = pedidoService.criarPedido(dto.getValor(), dto.getTipoFrete());
        return ResponseEntity.ok(new PedidoDTO(pedido));
    }

    @PostMapping("/{id}/pagar")
    public ResponseEntity<PedidoDTO> pagar(@PathVariable Long id) {
        Pedido pedido = pedidoService.pagarPedido(id);
        return ResponseEntity.ok(new PedidoDTO(pedido));
    }

    @PostMapping("/{id}/enviar")
    public ResponseEntity<PedidoDTO> enviar(@PathVariable Long id) {
        Pedido pedido = pedidoService.enviarPedido(id);
        return ResponseEntity.ok(new PedidoDTO(pedido));
    }

    @PostMapping("/{id}/cancelar")
    public ResponseEntity<PedidoDTO> cancelar(@PathVariable Long id) {
        Pedido pedido = pedidoService.cancelarPedido(id);
        return ResponseEntity.ok(new PedidoDTO(pedido));
    }
}