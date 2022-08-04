package com.sena.webfavorites.converters;

import com.sena.webfavorites.dtos.ProductoDTO;
import com.sena.webfavorites.entity.Producto;

public class ProductoConv extends AbstracConverter<Producto, ProductoDTO>{

	@Override
	public Producto toEntity(ProductoDTO dto) {
		return Producto.builder()
				.idProducto(dto.getIdProducto())
				.idUsuario(dto.getIdUsuario())
				.idCategoria(dto.getIdCategoria())
				.nombre(dto.getNombre())
				.cantidad(dto.getCantidad())
				.descripcion(dto.getDescripcion())
				.imagen(dto.getImagen())
				.fechacreacion(dto.getFechaCreacion())
				.build();
	}

	@Override
	public ProductoDTO toDTO(Producto entity) {
		return ProductoDTO.builder()
				.idProducto(entity.getIdProducto())
				.idUsuario(entity.getIdUsuario())
				.idCategoria(entity.getIdCategoria())
				.nombre(entity.getNombre())
				.cantidad(entity.getCantidad())
				.descripcion(entity.getDescripcion())
				.imagen(entity.getImagen())
				.fechaCreacion(entity.getFechacreacion())
				.build();
	}


}
