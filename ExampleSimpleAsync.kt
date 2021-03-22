import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TestActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val async = SimpleAsync
            .Builder<Unit, Unit, Unit>() // create builder object
            .setBackground {
               // background
            }
            .setPostExecute {
                //posExecute
            }
            .setPreExecute {
                //preExecute
            }
            .build()
        async.execute()
    }
}
