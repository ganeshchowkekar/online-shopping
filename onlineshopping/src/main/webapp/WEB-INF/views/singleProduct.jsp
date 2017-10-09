<div class="container">
	<!-- Breadcrumb  -->
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">All Products</a></li>
				<li class="active">${product.name}</li>
			</ol>
		</div>
	</div>
	<div class="row">
		<!-- Dispaly the product image  -->
		<div class="col-sm-4">
			<div class="thumbnail">
				<img src="${images}/${product.code}.jpg" class="img img-responsive" />
			</div>
		</div>
		<!-- Display the product description -->
		<div class="col-sm-8">
			<h3>${product.name}</h3>
			<hr />
			<p>${product.description}</p>
			<hr />
			<h4>
				Price : <strong> &#8377; ${product.unitPrice}/-</strong>
			</h4>


			<c:choose>
				<c:when test="${product.quantity<1}">
					<h4>
						Qty. Available:<span style="color:red">Out of stock</span>
					</h4>
					<a href="javascript:void(0)" class="btn btn-success disabled"><strike><span
							class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</strike> &#160; &#160; &#160; <a
						href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
					</a>
				</c:when>
				<c:otherwise>
					<h4>Qty. Available: ${product.quantity}</h4>
					<a href="${contextRoot}/cart/add/${product.id}/product"
						class="btn btn-success"> <span
						class="glyphicon glyphicon-shopping-cart"></span>Add to Cart
					</a>
					<a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
				</c:otherwise>
			</c:choose>


		</div>
	</div>
</div>