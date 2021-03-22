
import android.os.AsyncTask

class SimpleAsync {


    class Building<A, B, C> {
        lateinit var mParamBackground: (Unit) -> C
        lateinit var mParamPostExecute: (C) -> Unit
        lateinit var mParamPreExecute: (Unit) -> Unit

        fun setBackground(params: (Unit) -> C): Building<A, B, C> {
            mParamBackground = params
            return this
        }

        fun setPostExecute(params: (C) -> Unit): Building<A, B, C> {
             mParamPostExecute = params
            return this
        }

        fun setPreExecute(params: (Unit) -> Unit): Building<A, B, C>{
            mParamPreExecute = params
            return this
        }

        fun build(): AsyncTask<A, B, C> {
            return CreatedAsyncTask<A, B,C>(this)
        }
    }


    class CreatedAsyncTask<A ,B, C> constructor(): android.os.AsyncTask<A, B ,C>(){
        private lateinit var mParamBackground: (Unit) -> C
        private lateinit var mParamPostExecute: (C) -> Unit
        private lateinit var mParamPreExecute: (Unit) -> Unit
        constructor(build: Building<A, B,C >) : this() {
            this.mParamBackground = build.mParamBackground
            this.mParamPostExecute = build.mParamPostExecute
            this.mParamPreExecute = build.mParamPreExecute
        }

        override fun onPreExecute() {
            mParamPreExecute(Unit)
            super.onPreExecute()
        }
        override fun doInBackground(vararg params: A): C {
            return mParamBackground(Unit)
        }

        override fun onPostExecute(result: C) {
            mParamPostExecute(result)
        }

    }


    companion object {
        fun <A,B,C>Builder(): Building<A,B,C>{
            return Building<A,B,C>()
        }
    }


}