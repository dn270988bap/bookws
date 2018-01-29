package com.sb.bookws.configuration;

import com.sb.bookws.bl.BlLayer;
import com.sb.bookws.dao.AuthorDao;
import com.sb.bookws.dao.BookDao;
import com.sb.bookws.dao.GenreDao;
import java.util.HashMap;
import java.util.Map;

public class Init {

    public Map<String, Object> initialization() {
        Map<String, Object> objmap = new HashMap();
        AuthorDao authordao = new AuthorDao();
        BookDao bookdao = new BookDao();
        GenreDao genredao = new GenreDao();
        BlLayer bl = new BlLayer();

        bl.setAuthordao(authordao);
        bl.setBookdao(bookdao);
        bl.setGenredao(genredao);

        objmap.put("authordao", authordao);
        objmap.put("book", bookdao);
        objmap.put("bl", bl);
        
        return objmap;
    }

}
