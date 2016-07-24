package ly.generalassemb.drewmahrt.shoppinglistwithdetailview;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", -1);

        ShoppingSQLiteOpenHelper db = ShoppingSQLiteOpenHelper.getInstance(this);
        Cursor cursor = db.getShoppingList();

        cursor.moveToPosition(position);

        TextView name = (TextView) findViewById(R.id.textviewName);
        TextView description = (TextView) findViewById(R.id.textviewDescription);
        TextView price = (TextView) findViewById(R.id.textviewPrice);
        TextView type = (TextView) findViewById(R.id.textviewType);

        String strName = "Item Name: " + cursor.getString(cursor.getColumnIndexOrThrow(ShoppingSQLiteOpenHelper.COL_ITEM_NAME));
        String strDesc = "Description: " + cursor.getString(cursor.getColumnIndexOrThrow(ShoppingSQLiteOpenHelper.COL_ITEM_DESCRIPTION));
        String strPrice = "Price: $" + cursor.getString(cursor.getColumnIndexOrThrow(ShoppingSQLiteOpenHelper.COL_ITEM_PRICE));
        String strType = "Item Type: " + cursor.getString(cursor.getColumnIndexOrThrow(ShoppingSQLiteOpenHelper.COL_ITEM_TYPE));

        name.setText(strName);
        description.setText(strDesc);
        price.setText(strPrice);
        type.setText(strType);


    }
}
