package tech.jhipster.lite.module.domain.packagejson;

import java.util.ArrayList;
import java.util.Collection;
import tech.jhipster.lite.error.domain.Assert;
import tech.jhipster.lite.module.domain.JHipsterModule.JHipsterModuleBuilder;

public class JHipsterModulePackageJson {

  private final Scripts scripts;
  private final PackageJsonDependencies dependencies;
  private final PackageJsonDependencies dependenciesToRemove;
  private final PackageJsonDependencies devDependencies;
  private final PackageJsonDependencies devDependenciesToRemove;

  private JHipsterModulePackageJson(JHipsterModulePackageJsonBuilder builder) {
    scripts = new Scripts(builder.scripts);
    dependencies = new PackageJsonDependencies(builder.dependencies);
    dependenciesToRemove = new PackageJsonDependencies(builder.dependenciesToRemove);
    devDependencies = new PackageJsonDependencies(builder.devDependencies);
    devDependenciesToRemove = new PackageJsonDependencies(builder.devDependenciesToRemove);
  }

  public static JHipsterModulePackageJsonBuilder builder(JHipsterModuleBuilder module) {
    return new JHipsterModulePackageJsonBuilder(module);
  }

  public boolean isEmpty() {
    return (
      scripts.isEmpty() &&
      dependencies.isEmpty() &&
      devDependencies.isEmpty() &&
      dependenciesToRemove.isEmpty() &&
      devDependenciesToRemove.isEmpty()
    );
  }

  public Scripts scripts() {
    return scripts;
  }

  public PackageJsonDependencies devDependencies() {
    return devDependencies;
  }

  public PackageJsonDependencies dependencies() {
    return dependencies;
  }

  public PackageJsonDependencies devDependenciesToRemove() {
    return devDependenciesToRemove;
  }

  public PackageJsonDependencies dependenciesToRemove() {
    return dependenciesToRemove;
  }

  public static class JHipsterModulePackageJsonBuilder {

    private final JHipsterModuleBuilder module;
    private final Collection<Script> scripts = new ArrayList<>();
    private final Collection<PackageJsonDependency> dependencies = new ArrayList<>();
    private final Collection<PackageJsonDependency> devDependencies = new ArrayList<>();
    private final Collection<PackageJsonDependency> dependenciesToRemove = new ArrayList<>();
    private final Collection<PackageJsonDependency> devDependenciesToRemove = new ArrayList<>();

    private JHipsterModulePackageJsonBuilder(JHipsterModuleBuilder module) {
      Assert.notNull("module", module);

      this.module = module;
    }

    public JHipsterModulePackageJsonBuilder addScript(ScriptKey key, ScriptCommand command) {
      scripts.add(new Script(key, command));

      return this;
    }

    public JHipsterModulePackageJsonBuilder addDependency(PackageName packageName, VersionSource versionSource) {
      dependencies.add(new PackageJsonDependency(packageName, versionSource));

      return this;
    }

    public JHipsterModulePackageJsonBuilder removeDependency(PackageName packageName, VersionSource versionSource) {
      dependenciesToRemove.add(new PackageJsonDependency(packageName, versionSource));
      return this;
    }

    public JHipsterModulePackageJsonBuilder addDevDependency(PackageName packageName, VersionSource versionSource) {
      devDependencies.add(new PackageJsonDependency(packageName, versionSource));

      return this;
    }

    public JHipsterModulePackageJsonBuilder removeDevDependency(PackageName packageName, VersionSource versionSource) {
      devDependenciesToRemove.add(new PackageJsonDependency(packageName, versionSource));
      return this;
    }

    public JHipsterModuleBuilder and() {
      return module;
    }

    public JHipsterModulePackageJson build() {
      return new JHipsterModulePackageJson(this);
    }
  }
}
