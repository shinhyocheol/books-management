package com.example.app.config.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class ReplicationRoutingDataSource extends AbstractRoutingDataSource {

    // AbstractRoutingDataSource 추상클래스를 상속받아 determineCurrentLookupKey()를 구현
    // 트랜잭션 동기화 클래스에서 트랜잭션의 readOnly값을 확인하고, 사용할 데이터소스 타입을 반환한다.
    @Override
    protected Object determineCurrentLookupKey() {
        boolean isReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();

        if(isReadOnly) {
            return "slave";
        } else {
            return "master";
        }
    }
}
