package HCLScopePackage;

import com.google.inject.Inject;
import javax.inject.Provider;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.xtext.example.hclscope.hclScope.HclScopePackage;

@SuppressWarnings("all")
public class HCLXtendClass {
  @Inject
  private static Provider<IFileSystemAccess2> fileSystemAccessProvider;
  
  public static void main(final String[] args) {
    final HCLGenerator gen = new HCLGenerator();
    final HclScopePackage temp = HclScopePackage.eINSTANCE;
    final CharSequence charseq = gen.compile(temp);
    final GeneratorContext context = new GeneratorContext();
    InputOutput.<CharSequence>println(charseq);
  }
}
