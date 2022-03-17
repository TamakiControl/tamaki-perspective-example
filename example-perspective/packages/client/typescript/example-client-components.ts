import {ComponentMeta, ComponentRegistry} from '@inductiveautomation/perspective-client';
import {Counter, CounterMeta} from "./components/counter";


// export so the components are referencable
export {Counter, CounterMeta};

// as new components are implemented, import them, and add their meta to this array
const components: Array<ComponentMeta> = [
    // list components to export here
    new CounterMeta()
];

// iterate through our components, registering each one with the registry.  Don't forget to register on the Java side too!
components.forEach((c: ComponentMeta) => ComponentRegistry.register(c) );
