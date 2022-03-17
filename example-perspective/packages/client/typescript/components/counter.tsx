import * as React from 'react';
import {
    ComponentMeta,
    ComponentProps,
    PComponent,
    PropertyTree,
    SizeObject
} from "@inductiveautomation/perspective-client";


export const COMPONENT_ID = "counter";

export interface CounterProps {
}

export function Counter(props: ComponentProps<CounterProps>) {
    const {props: {}} = props;

    return (
        <div>
            Hello World
        </div>
    );
}

export class CounterMeta implements ComponentMeta {

    getPropsReducer(tree: PropertyTree): CounterProps {
        return {};
    }

    getComponentType(): string {
        return COMPONENT_ID;
    }

    getDefaultSize(): SizeObject {
        return {
            width: 100,
            height: 100
        };
    }

    getViewComponent(): PComponent {
        return Counter;
    }

}
