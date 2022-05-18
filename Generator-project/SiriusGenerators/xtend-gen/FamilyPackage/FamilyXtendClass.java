package FamilyPackage;

import com.google.inject.Inject;
import javax.inject.Provider;
import org.eclipse.sirius.sample.basicfamily.BasicfamilyFactory;
import org.eclipse.sirius.sample.basicfamily.BasicfamilyPackage;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class FamilyXtendClass {
  @Inject
  private static Provider<IFileSystemAccess2> fileSystemAccessProvider;
  
  public static void main(final String[] args) {
    final BasicfamilyFactory BasicfamilyFactory = org.eclipse.sirius.sample.basicfamily.BasicfamilyFactory.eINSTANCE;
    final FamilyGenerator gen = new FamilyGenerator();
    final BasicfamilyPackage temp = BasicfamilyPackage.eINSTANCE;
    final CharSequence charseq = gen.compile(temp);
    InputOutput.<CharSequence>println(charseq);
  }
}
