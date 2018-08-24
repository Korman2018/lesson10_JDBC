package com.library.DAO.Impl;

import com.library.DAO.StatusDAO;
import com.library.DAO.mappers.StatusMapper;
import com.library.model.Status;
import org.springframework.stereotype.Repository;

@Repository
public class StatusDAOImpl extends AbstractEnumDAOImpl<Status> implements StatusDAO {
    StatusDAOImpl() {
        super(new StatusMapper(), "status");
    }
}
