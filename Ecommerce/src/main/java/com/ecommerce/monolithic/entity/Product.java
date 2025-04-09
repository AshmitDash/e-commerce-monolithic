package com.ecommerce.monolithic.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, length = 500)
	private String description;

	@Column(nullable = false)
	private Double price;

	@Column(nullable = false)
	private Integer quantity;

	@Column(nullable = false)
	private String category;

//    private String imageUrl;
//
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;

}
