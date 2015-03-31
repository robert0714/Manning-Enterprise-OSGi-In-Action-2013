package fancyfoods.department.cheese.test;

import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.options.extra.DirScannerProvisionOption;

import static org.ops4j.pax.exam.CoreOptions.*;

public class PaxConfigurer {

    public static Option[] getServerPlatform() {
        String ariesAssemblyDir = System.getenv().get("ARIES_ASSEMBLY") + "/target"; 

        Option bootPackages = bootDelegationPackages(
            "javax.transaction", "javax.transaction.*");
        String f = "*-*.jar";
        DirScannerProvisionOption unfiltered = 
            scanDir(ariesAssemblyDir);
        Option ariesAsembly = unfiltered.filter(f);
        Option osgiFramework = equinox().version("3.5.0");
        return options(bootPackages, ariesAsembly, junitBundles(),
                osgiFramework);
    }
}
