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
    count: number;
    setCount: Function;
}

export function Counter(props: ComponentProps<CounterProps>) {
    const {props: { count, setCount }} = props;

    return (
        <div>
            <button
                onClick={() => setCount(count + 1)}
                style={{ width: "100%", height: "100%" }}>
                <h1>{count}</h1>
            </button>
        </div>
    );
}

export class CounterMeta implements ComponentMeta {

    getPropsReducer(tree: PropertyTree): CounterProps {
        return {
            count: tree.read("count", 0),
            setCount: (count: number) => tree.write("count", count)
        };
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
