package com.demo.mvc.repository;

import com.demo.mvc.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface inventoryRepo extends JpaRepository<Inventory, Long> {

    @Query(value = "select inv_UPA, inv_rtn_qty, inv_seller, inv_item_brand, inv_todo, DATE_FORMAT(NOW(), '%m/%d/%Y') as curdate from inventory where inv_UPA = ?1", nativeQuery = true)
    String searchByUpa(String UPA);

    @Query(value = "SELECT DATE_FORMAT(UPDATE_TIME, '%m/%d/%Y') as lastTime FROM   information_schema.tables WHERE  TABLE_SCHEMA = 'FastTrackIT' AND TABLE_NAME = 'inventory'", nativeQuery = true)
    String getLastDate();

    String uploadQuery = "LOAD DATA LOCAL INFILE ?1 REPLACE INTO TABLE inventory " +
            "FIELDS TERMINATED BY ',' " +
            "ENCLOSED BY '\"'  " +
            "LINES TERMINATED BY '\n' " +
            "IGNORE 1 LINES " +
            "(inv_UPA,inv_thumbnail,inv_rtn_qty,inv_seller,inv_item_brand,inv_item_desc,inv_Amount,inv_model,inv_load,@inv_width,@inv_depth,@inv_height,@inv_weight,inv_additional_info,inv_todo)" +
            "set inv_width= if(@inv_width = '',0,@inv_width), " +
            "inv_depth= if(@inv_depth = '',0,@inv_depth), " +
            "inv_height= if(@inv_height = '',0,@inv_height), " +
            "inv_weight= if(@inv_weight = '',0,@inv_weight)";

    @Query(value = uploadQuery, nativeQuery = true)
    long uploadData(String filename);
}
