package pe.edu.cibertec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.Entity.Compra;
import pe.edu.cibertec.repository.CompraRepository;
import pe.edu.cibertec.response.AddCompraResponse;
import pe.edu.cibertec.response.DeleteCompraResponse;
import pe.edu.cibertec.response.FindCompraResponse;
import pe.edu.cibertec.response.UpdateCompraResponse;

import java.util.List;

@RestController
@RequestMapping("/compra")
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @PostMapping("/AgregarCompra")
    public AddCompraResponse agregarCompra(@RequestBody Compra compra) {
        if (compra.getId_compra() != 0) {
            return new AddCompraResponse("99", "El ID de la compra no debe estar presente para agregar una nueva compra");
        }

        compraRepository.save(compra);
        return new AddCompraResponse("01", null);
    }

    @GetMapping("/BuscarCompra")
    public FindCompraResponse buscarCompra(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        Iterable<Compra> compras;
        if (id > 0) {
            compras = compraRepository.findAllById(List.of(id));
        } else {
            compras = compraRepository.findAll();
        }
        return new FindCompraResponse("01", null, compras);
    }

    @PostMapping("/ActualizarCompra")
    public UpdateCompraResponse actualizarCompra(@RequestBody Compra compra) {
        if (!compraRepository.existsById(compra.getId_compra())) {
            return new UpdateCompraResponse("99", "La compra no existe");
        }

        compraRepository.save(compra);
        return new UpdateCompraResponse("01", null);
    }

    @DeleteMapping("/EliminarCompra")
    public DeleteCompraResponse eliminarCompra(@RequestBody Compra compra) {
        if (!compraRepository.existsById(compra.getId_compra())) {
            return new DeleteCompraResponse("99", "La compra no existe");
        }

        compraRepository.delete(compra);
        return new DeleteCompraResponse("01", null);
    }
}
