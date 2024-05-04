package com.example.binlistapp.history.data

import com.example.binlistapp.history.data.bd.BINInfoDao
import com.example.binlistapp.history.data.bd.entity.BINInfoEntity
import com.example.binlistapp.history.data.mapper.CardInfoBdMapper
import com.example.binlistapp.history.domain.HistoryRepository
import com.example.binlistapp.history.domain.model.FullCardInfo
import com.example.binlistapp.search.domain.model.CardInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HistoryRepositoryImpl(
    private val dao: BINInfoDao,
    private val cardInfoBdMapper: CardInfoBdMapper
) : HistoryRepository {
    override fun getHistory(): Flow<List<FullCardInfo>> = flow {
        val historyList = dao.getHistory()
        emit(convertToInfoData(historyList))
    }

    override suspend fun setToHistory(bin: String, cardInfo: CardInfo) {
        dao.setBinInfo(cardInfoBdMapper.map(bin, cardInfo))
    }

    override suspend fun clearHistory() {
        dao.clearHistory()
    }

    private fun convertToInfoData(historyList: List<BINInfoEntity>): List<FullCardInfo> {
        return historyList.map { item -> cardInfoBdMapper.map(item) }
    }
}
