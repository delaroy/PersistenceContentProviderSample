/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.delaroystudios.roomcontentprovider.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;


/**
 * Data access object for Menu.
 */
@Dao
public interface MenuDao {

    /**
     * Counts the number of menus in the table.
     *
     * @return The number of menus.
     */
    @Query("SELECT COUNT(*) FROM " + Menu.TABLE_NAME)
    int count();

    /**
     * Inserts a menu into the table.
     *
     * @param menu A new menu.
     * @return The row ID of the newly inserted menu.
     */
    @Insert
    long insert(Menu menu);

    /**
     * Inserts multiple menus into the database
     *
     * @param menus An array of new menus.
     * @return The row IDs of the newly inserted menus.
     */
    @Insert
    long[] insertAll(Menu[] menus);

    /**
     * Select all menus.
     *
     * @return A {@link Cursor} of all the menus in the table.
     */
    @Query("SELECT * FROM " + Menu.TABLE_NAME)
    Cursor selectAll();

    /**
     * Select a menu by the ID.
     *
     * @param id The row ID.
     * @return A {@link Cursor} of the selected menu.
     */
    @Query("SELECT * FROM " + Menu.TABLE_NAME + " WHERE " + Menu.COLUMN_ID + " = :id")
    Cursor selectById(long id);

    /**
     * Delete a menu by the ID.
     *
     * @param id The row ID.
     * @return A number of menus deleted. This should always be {@code 1}.
     */
    @Query("DELETE FROM " + Menu.TABLE_NAME + " WHERE " + Menu.COLUMN_ID + " = :id")
    int deleteById(long id);

    /**
     * Update the menu. The menu is identified by the row ID.
     *
     * @param menu The menu to update.
     * @return A number of menus updated. This should always be {@code 1}.
     */
    @Update
    int update(Menu menu);

}
