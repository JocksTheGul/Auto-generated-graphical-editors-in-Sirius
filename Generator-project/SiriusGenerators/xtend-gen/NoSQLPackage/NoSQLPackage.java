package NoSQLPackage;

import NoSQL_Schema.NoSQL_SchemaPackage;
import com.google.inject.Inject;
import javax.inject.Provider;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class NoSQLPackage {
  @Inject
  private static Provider<IFileSystemAccess2> fileSystemAccessProvider;
  
  public static void main(final String[] args) {
    final NoSQLGenerator gen = new NoSQLGenerator();
    final NoSQL_SchemaPackage temp = NoSQL_SchemaPackage.eINSTANCE;
    final CharSequence charseq = gen.compile(temp);
    final GeneratorContext context = new GeneratorContext();
    InputOutput.<CharSequence>println(charseq);
  }
}
