/** Assignment: Beer Advisor (Chapter 2 Demo)
 *  @author: Emilio Cruz
 *  @date: 2/5/23
 */

package edu.quinnipiac.ser210.chapter2demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findBeer = findViewById<Button>(R.id.find_beer)
        findBeer.setOnClickListener()
        {
            val beerColor = findViewById<Spinner>(R.id.beer_color)
            val brands = findViewById<TextView>(R.id.brands)
            val color = beerColor.selectedItem

            val beerList = getBeers(color.toString())
            val beers = beerList.reduce{ str, item -> str + '\n' + item }

            brands.text = beers

        }
    }

    fun getBeers(color: String) : List<String>
    {
        return when (color)
        {
            "Light" -> listOf("Jail Pale Ale", "Lager Lite")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            else -> listOf("Gout Stout", "Dark Daniel")
        }
    }
}