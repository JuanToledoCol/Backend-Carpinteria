package com.sena.webfavorites.converters;

import com.sena.webfavorites.dtos.ProductoDTO;
import com.sena.webfavorites.entity.Producto;

public class ProductoConv extends AbstracConverter<Producto, ProductoDTO>{

	@Override
	public Producto toEntity(ProductoDTO dto) {
		return Producto.builder()
				.idProducto(dto.getIdProducto())
				.idCategoria(dto.getIdCategoria())
				.nombreProducto(dto.getNombreProducto())
				.stock(dto.getStock())
				.descripcion(dto.getDescripcion())
				.precio(dto.getPrecio())
				.fechaCreacionProducto(dto.getFechaCreacionProducto())
				.build();
	}

	@Override
	public ProductoDTO toDTO(Producto entity) {
		return ProductoDTO.builder()
				.idProducto(entity.getIdProducto())
				.idCategoria(entity.getIdCategoria())
				.nombreProducto(entity.getNombreProducto())
				.stock(entity.getStock())
				.descripcion(entity.getDescripcion())
				.precio(entity.getPrecio())
				.fechaCreacionProducto(entity.getFechaCreacionProducto())
				.build();
	}


}
