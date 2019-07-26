import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

import java.util.EnumSet;

public class HibernateTest {
        public static void main(String[] args) {
            //5.2以前的使用正向工程
//            Configuration cfg = new Configuration().configure();
//            SchemaExport export = new SchemaExport(cfg);
//            export.create(true, true);
        //5.2加载配置文件正向工程
        ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(registry).buildMetadata();
        SchemaExport export = new SchemaExport();
        export.create(EnumSet.of(TargetType.DATABASE),metadata);

    }
}
