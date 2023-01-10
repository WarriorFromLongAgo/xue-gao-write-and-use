define(["./Transforms-713aa3a8","./Matrix2-163b5a1d","./Matrix3-b6f074fa","./ComponentDatatype-77274976","./CylinderGeometryLibrary-20be4f8b","./defaultValue-0a909f67","./GeometryAttribute-0b8b7b82","./GeometryAttributes-f06a2792","./GeometryOffsetAttribute-04332ce7","./IndexDatatype-2149f06c","./Math-e97915da","./combine-ca22a614","./RuntimeError-06c93819","./WebGLConstants-a8cc3e8c"],(function(t,e,i,n,o,a,r,s,u,f,c,d,l,b){"use strict";const m=new e.Cartesian2;function p(t){const e=(t=a.defaultValue(t,a.defaultValue.EMPTY_OBJECT)).length,i=t.topRadius,n=t.bottomRadius,o=a.defaultValue(t.slices,128),r=Math.max(a.defaultValue(t.numberOfVerticalLines,16),0);this._length=e,this._topRadius=i,this._bottomRadius=n,this._slices=o,this._numberOfVerticalLines=r,this._offsetAttribute=t.offsetAttribute,this._workerName="createCylinderOutlineGeometry"}p.packedLength=6,p.pack=function(t,e,i){return i=a.defaultValue(i,0),e[i++]=t._length,e[i++]=t._topRadius,e[i++]=t._bottomRadius,e[i++]=t._slices,e[i++]=t._numberOfVerticalLines,e[i]=a.defaultValue(t._offsetAttribute,-1),e};const y={length:void 0,topRadius:void 0,bottomRadius:void 0,slices:void 0,numberOfVerticalLines:void 0,offsetAttribute:void 0};return p.unpack=function(t,e,i){e=a.defaultValue(e,0);const n=t[e++],o=t[e++],r=t[e++],s=t[e++],u=t[e++],f=t[e];return a.defined(i)?(i._length=n,i._topRadius=o,i._bottomRadius=r,i._slices=s,i._numberOfVerticalLines=u,i._offsetAttribute=-1===f?void 0:f,i):(y.length=n,y.topRadius=o,y.bottomRadius=r,y.slices=s,y.numberOfVerticalLines=u,y.offsetAttribute=-1===f?void 0:f,new p(y))},p.createGeometry=function(c){let d=c._length;const l=c._topRadius,b=c._bottomRadius,p=c._slices,y=c._numberOfVerticalLines;if(d<=0||l<0||b<0||0===l&&0===b)return;const _=2*p,h=o.CylinderGeometryLibrary.computePositions(d,l,b,p,!1);let A,R=2*p;if(y>0){const t=Math.min(y,p);A=Math.round(p/t),R+=t}const G=f.IndexDatatype.createTypedArray(_,2*R);let O,V=0;for(O=0;O<p-1;O++)G[V++]=O,G[V++]=O+1,G[V++]=O+p,G[V++]=O+1+p;if(G[V++]=p-1,G[V++]=0,G[V++]=p+p-1,G[V++]=p,y>0)for(O=0;O<p;O+=A)G[V++]=O,G[V++]=O+p;const L=new s.GeometryAttributes;L.position=new r.GeometryAttribute({componentDatatype:n.ComponentDatatype.DOUBLE,componentsPerAttribute:3,values:h}),m.x=.5*d,m.y=Math.max(b,l);const g=new t.BoundingSphere(i.Cartesian3.ZERO,e.Cartesian2.magnitude(m));if(a.defined(c._offsetAttribute)){d=h.length;const t=c._offsetAttribute===u.GeometryOffsetAttribute.NONE?0:1,e=new Uint8Array(d/3).fill(t);L.applyOffset=new r.GeometryAttribute({componentDatatype:n.ComponentDatatype.UNSIGNED_BYTE,componentsPerAttribute:1,values:e})}return new r.Geometry({attributes:L,indices:G,primitiveType:r.PrimitiveType.LINES,boundingSphere:g,offsetAttribute:c._offsetAttribute})},function(t,e){return a.defined(e)&&(t=p.unpack(t,e)),p.createGeometry(t)}}));
