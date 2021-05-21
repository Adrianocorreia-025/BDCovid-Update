package ar.adriano.bdasecovid

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class Tabela_Enfermeiros (db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db

    fun cria() {
        db.execSQL("CREATE TABLE $NOME_ENFERMEIRO (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $DATA_TESTE TEXT NOT NULL,M$CONTACTO TEXT NOT NULL, $IDENFERMEIRO INTEGER NOT NULL, FOREIGN KEY($IDENFERMEIRO ) REFERENCES ${TabelaCategorias.NOME_TABELA})")
    }

    fun insert(values: ContentValues): Long {
        return db.insert(TabelaCategorias.NOME_TABELA, null, values)
    }

    fun update(values: ContentValues, whereClause: String, whereArgs: Array<String>): Int {
        return db.update(TabelaCategorias.NOME_TABELA, values, whereClause, whereArgs)
    }

    fun delete(whereClause: String, whereArgs: Array<String>): Int {
        return db.delete(TabelaCategorias.NOME_TABELA, whereClause, whereArgs)
    }

    fun query(
        columns: Array<String>,
        selection: String,
        selectionArgs: Array<String>,
        groupBy: String,
        having: String,
        orderBy: String
    ): Cursor? {
        return db.query(TabelaCategorias.NOME_TABELA, columns, selection, selectionArgs, groupBy, having, orderBy)
    }

    companion object {
        const val NOME_ENFERMEIRO = "NOME"
        const val DATA_TESTE = "DATA"
        const val CONTACTO = "CONTACTO"
        const val IDENFERMEIRO = "ID"
    }
}
