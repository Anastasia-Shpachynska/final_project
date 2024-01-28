package com.example.final_project.api.controller.personal;

import com.example.final_project.api.data.responce.ResponseData;
import com.example.final_project.api.data.responce.wishlist.WishlistData;
import com.example.final_project.facade.WishlistFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/private/personal/wishlist")
public class WishlistController {

    private final WishlistFacade wishlistFacade;

    @GetMapping({"/addToWishlist/{productId}"})
    public ResponseEntity<ResponseData<WishlistData>> addToWishlist(@PathVariable Long productId) {
        return ResponseEntity.ok(new ResponseData<>(wishlistFacade.addToWishlist(productId)));
    }
}
