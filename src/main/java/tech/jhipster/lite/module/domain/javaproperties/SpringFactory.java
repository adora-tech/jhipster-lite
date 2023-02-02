package tech.jhipster.lite.module.domain.javaproperties;

import tech.jhipster.lite.error.domain.Assert;

public class SpringFactory {

  private final SpringFactoryType type;
  private final PropertyKey key;
  private final PropertyValue value;

  public SpringFactory(SpringFactoryBuilder builder) {
    Assert.notNull("key", builder.key);
    Assert.notNull("value", builder.value);

    type = builder.type;
    key = builder.key;
    value = builder.value;
  }

  public static SpringFactoryBuilder builder(SpringFactoryType type) {
    return new SpringFactoryBuilder(type);
  }

  public SpringFactoryType type() {
    return type;
  }

  public PropertyKey key() {
    return key;
  }

  public PropertyValue value() {
    return value;
  }

  public static class SpringFactoryBuilder implements SpringFactoryKeyBuilder, SpringFactoryValueBuilder {

    private final SpringFactoryType type;
    private PropertyKey key;
    private PropertyValue value;

    private SpringFactoryBuilder(SpringFactoryType type) {
      Assert.notNull("type", type);

      this.type = type;
    }

    @Override
    public SpringFactoryBuilder key(PropertyKey key) {
      this.key = key;

      return this;
    }

    @Override
    public SpringFactoryBuilder value(PropertyValue value) {
      this.value = value;

      return this;
    }

    @Override
    public SpringFactory build() {
      return new SpringFactory(this);
    }
  }

  // todo maybe make a common interface ?
  // todo or a single one
  public interface SpringFactoryKeyBuilder {
    SpringFactoryKeyBuilder key(PropertyKey key);

    SpringFactory build();
  }

  public interface SpringFactoryValueBuilder {
    SpringFactoryValueBuilder value(PropertyValue value);
  }
}
