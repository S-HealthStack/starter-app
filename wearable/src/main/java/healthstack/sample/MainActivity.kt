package healthstack.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import healthstack.common.model.PrivDataType.ACCELEROMETER
import healthstack.common.model.PrivDataType.ECG
import healthstack.common.model.PrivDataType.HEARTRATE
import healthstack.wearable.support.BaseActivity

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val healthDataTypes = listOf(ACCELEROMETER, ECG, HEARTRATE)

        setContent {
            BaseActivity(
                activity = this,
                healthDataTypes
            )
        }
    }
}
